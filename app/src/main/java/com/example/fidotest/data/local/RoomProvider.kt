package com.example.fidotest.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fidotest.data.local.dao.ArticleDao
import com.example.fidotest.data.local.entities.ArticleEntity

object RoomProvider {
    @Database(entities = [ArticleEntity::class], version = 1)
    abstract class ArticleDb : RoomDatabase() {
        abstract fun articleDao(): ArticleDao
    }

    fun provideDatabase(context: Context) = Room.databaseBuilder(
        context,
        ArticleDb::class.java, "articles-db"
    ).build()

    fun provideArticleDao(db: ArticleDb) = db.articleDao()
}