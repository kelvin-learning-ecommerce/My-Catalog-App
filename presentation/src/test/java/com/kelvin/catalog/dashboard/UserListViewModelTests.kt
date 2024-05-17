package com.kelvin.catalog.dashboard

import com.google.common.truth.Truth.assertThat
import com.kelvin.catalog.dashboard.viewmodel.DashboardViewModel
import com.kelvin.catalog.dispatcher.MainDispatcherRule
import com.kelvin.domain.usecase.DeleteCatalogUseCase
import com.kelvin.domain.usecase.FetchCatalogUseCase
import com.kelvin.domain.usecase.SaveCatalogUseCase
import com.kelvin.domain.usecase.UsersUseCase
import com.kelvin.githubapiapp.popularlist.dummyCatalogEntity
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class UserListViewModelTests {
    @ExperimentalCoroutinesApi
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var usersUseCase: UsersUseCase
    private lateinit var saveCatalogUseCase: SaveCatalogUseCase
    private lateinit var deleteCatalogUseCase: DeleteCatalogUseCase
    private lateinit var fetchCatalogUseCase: FetchCatalogUseCase
    private lateinit var viewModel: DashboardViewModel

    @Before
    fun setUp() {
        usersUseCase = mockk(relaxed = true)
        saveCatalogUseCase = mockk(relaxed = true)
        deleteCatalogUseCase = mockk(relaxed = true)
        fetchCatalogUseCase = mockk(relaxed = true)
        viewModel = DashboardViewModel(
            usersUseCase,
            saveCatalogUseCase,
            deleteCatalogUseCase,
            fetchCatalogUseCase
        )
    }

    @Test
    fun `onRequestLoading when Popular state is empty update isLoading state to true`() = runTest {
        viewModel.updateState(data = emptyList())
        viewModel.onRequestLoading()

        val isLoadingState = viewModel.state.value.isLoading

        assertThat(isLoadingState).isTrue()
    }

    @Test
    fun `when error message is not null update error state`() = runTest {
        val errorMsg = "Hi This is an Error"

        viewModel.onRequestError(errorMsg)

        val errorState = viewModel.state.value.error

        assertThat(errorState).isNotEmpty()
    }

    @Test
    fun `onRequestSuccess update the movie list state`() = runTest {
        val testList = dummyCatalogEntity
        viewModel.updateState(data = testList)

//        viewModel.onRequestSuccess(listOfMovie)

        val movieState = viewModel.state.value.data

        assertThat(movieState).isNotEmpty()
        assertThat(movieState).isEqualTo(testList)
    }

    @Test
    fun `onRequestSuccess update pagination state when data is not empty or didn't reached the limit`() =
        runTest {
            viewModel.onRequestSuccess(dummyCatalogEntity)

            val actualIsLoadingState = viewModel.paginationState.value.isLoading

            assertThat(actualIsLoadingState).isFalse()
        }

    @Test
    fun `onRequestSuccess update pagination state when data is empty`() = runTest {
        viewModel.updateState(data = dummyCatalogEntity)
        viewModel.onRequestSuccess(emptyList())

        val actualIsLoadingState = viewModel.paginationState.value.isLoading

        assertThat(actualIsLoadingState).isFalse()
    }

    @Test
    fun `when getUsers called and result is Success`() = runTest {
        viewModel.onRequestSuccess(dummyCatalogEntity)

        val actualmovieList = viewModel.state.value.data
        val actualIsLoading = viewModel.paginationState.value.isLoading

        assertThat(actualmovieList).isEqualTo(dummyCatalogEntity)
        assertThat(actualIsLoading).isFalse()
    }

    @Test
    fun `when getUsers called and result is Error`() = runTest {
        val errorMsg = "Error occurred"
        viewModel.onRequestError(errorMsg)

        val actualError = viewModel.state.value.error

        assertThat(actualError).isNotEmpty()
        assertThat(actualError).isEqualTo(errorMsg)
    }

    @Test
    fun `when getUsers called and result is Loading when movie state is empty`() = runTest {
        viewModel.updateState()

        viewModel.onRequestLoading()

        val actualIsLoading = viewModel.state.value.isLoading
        val actualPaginationIsLoading = viewModel.paginationState.value.isLoading

        assertThat(actualIsLoading).isTrue()
        assertThat(actualPaginationIsLoading).isFalse()
    }
}
