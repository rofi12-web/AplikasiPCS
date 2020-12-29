package com.sportapp.data.repository

import com.sportapp.data.model.ActionState
import com.sportapp.data.model.News
import com.sportapp.remote.NewsService
import com.sportapp.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class NewsRepository {
    private val newsService: NewsService by lazy { RetrofitApi.newsService() }

    suspend fun listNews() : ActionState<List<News>>{
        return  try {
            val list = newsService.listNews().await()
            ActionState(list.amiibo)
        }catch (e: Exception ){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailNews(url: String) : ActionState<News> {
        return try {
            val list = newsService.detailNews(url).await()
            ActionState(list.amiibo.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchNews(query: String) : ActionState<List<News>> {
        return try {
            val list = newsService.searchNews(query).await()
            ActionState(list.amiibo)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}