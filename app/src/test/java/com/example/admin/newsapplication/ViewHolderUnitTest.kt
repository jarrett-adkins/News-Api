package com.example.admin.newsapplication

import android.content.Context
import com.example.admin.newsapplication.model.Model
import com.example.admin.newsapplication.viewModel.ViewModel
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class ViewHolderUnitTest {

    lateinit var viewModel: ViewModel

    @Mock
    var article : Model.Article = mockk()
    var mMockContext: Context = mockk()

    @Before
    fun setUp() {
        viewModel = ViewModel()
        viewModel.initDatabase(mMockContext)
    }

    @Test
    fun testFavoritesCheck()  {
        var url = "http://www.economist.com/news/leaders/21734451-it-really-bad-one-year-old-trump-presidency"
        every { article.url } returns url
        assertEquals(true, viewModel.isFavorited(article))
    }
}