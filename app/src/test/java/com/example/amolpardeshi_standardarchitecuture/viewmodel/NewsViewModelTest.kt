//package com.example.amolpardeshi_standardarchitecuture.viewmodel
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import androidx.lifecycle.Observer
//import com.example.amolpardeshi_standardarchitecuture.model.NewsResponseDto
//import com.example.amolpardeshi_standardarchitecuture.repo.DummyNewsRepository
//import com.example.amolpardeshi_standardarchitecuture.repo.NewsRepository
//import com.example.amolpardeshi_standardarchitecuture.utils.Resource
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.runBlocking
//import kotlinx.coroutines.test.TestCoroutineDispatcher
//import kotlinx.coroutines.test.setMain
//import org.junit.*
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.MockitoAnnotations
//import org.mockito.junit.MockitoJUnitRunner
//
//@ExperimentalCoroutinesApi
//@RunWith(MockitoJUnitRunner::class)
//class NewsViewModelTest {
//
//    private lateinit var viewModel: NewsViewModel
//
//    private lateinit var repository: DummyNewsRepository
//
//    @Mock
//    private lateinit var newsObserver: Observer<List<NewsResponseDto>>
//
//    @get:Rule
//    val rule = InstantTaskExecutorRule()
//
//    private val testDispatcher = TestCoroutineDispatcher()
//
//    @Before
//    fun setUp() {
//        repository = DummyNewsRepository()
//        MockitoAnnotations.openMocks(this)
//        Dispatchers.setMain(testDispatcher)
//        viewModel = NewsViewModel(repository)
//        viewModel.newsLiveData.observeForever(newsObserver)
//    }
//
//    @After
//    fun tearDown() {
//        viewModel.newsLiveData.removeObserver(newsObserver)
//    }
//
//    @Test
//    fun `test getData() with success response`() = runBlocking{
//        val mockData = getDummyDataList()
//        Mockito.`when`(repository.getNewsData()).thenReturn(Resource.success(mockData))
//
//        viewModel.getData()
//
//        Mockito.verify(newsObserver).onChanged(mockData.sortedByDescending { it.timeCreated })
//    }
//
//    @Test
//    fun `test getData() with error response`() = runBlocking{
//        Mockito.`when`(repository.getNewsData()).thenReturn(Resource.error("Error", null))
//
//        viewModel.getData()
//
//        Mockito.verify(newsObserver, Mockito.never()).onChanged(Mockito.anyList())
//    }
//
//    @Test
//    fun `test sortByRecent() method`() {
//        val mockData = getDummyDataList()
//        viewModel.newsLiveData.postValue(mockData)
//
//        viewModel.sortByRecent()
//
//        Mockito.verify(newsObserver).onChanged(mockData.sortedByDescending { it.timeCreated })
//    }
//
//    @Test
//    fun `test sortByPopular() method`() {
//        val mockData = getDummyDataList()
//        viewModel.newsLiveData.postValue(mockData)
//
//        viewModel.sortByPopular()
//
//        Mockito.verify(newsObserver)
//            .onChanged(mockData.sortedWith(compareBy<NewsResponseDto> { it.rank }.thenByDescending { it.timeCreated }))
//    }
//
//    fun getDummyDataList() = listOf(
//        NewsResponseDto(
//            id = "121",
//            title = "Carousell is launching its own digital wallet to improve payments for its users",
//            description = "Due to launch next month in Singapore, CarouPay will allow buyers and sellers to complete transactions without leaving the Carousell app, rather than having to rely on third-party platforms or doing meet-ups to hand over cash. CarouPay will be a digital wallet within the Carousell app. \"More than half of our sellers will end up buying items as well, so maybe it makes sense to have that money in the wallet for purchases\" - Quek tells Tech in Asia.",
//            bannerUrl = "https://storage.googleapis.com/carousell-interview-assets/android/images/carousell-siu-rui-ceo-tia-sg-2018.jpg",
//            timeCreated = 1532853058,
//            rank = 2
//        ), NewsResponseDto(
//            id = "122",
//            title = "Southeast Asia-based mobile listings startup Carousell raises $85M",
//            description = "Carousell, the Singapore-based mobile listing service that operates across Southeast Asia, has pulled in an $85 million Series C fund as it seeks to strengthen its business among the region's competitive e-commerce landscape before expanding globally.",
//            bannerUrl = "https://storage.googleapis.com/carousell-interview-assets/android/images/carousell-hero-image_10june.png",
//            timeCreated = 1532939458,
//            rank = 5
//        )
//    )
//
//}
