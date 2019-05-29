package com.xg.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {
    val words = "The quick brown fox jumps over the lazy dog"
    val numbers = listOf("one", "two", "three", "four")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // testOne()
        // testTwo()
        //testThree()
        // testFour()
        // testFive()

        //测试git操作333333333333333333333333333333333333
        //李四开发的项目模块
        //李四开发的项目模块测试2
        //王五开发的项目模块测试合并冲突
        testSix()
    }

    //分组
    private fun testSix() {
        //王五开发的项目模块
        val data = listOf("a", "ab", "bc", "ba", "cd", "cd", "cc", "dd", "dd", "ad")
        data.groupBy { it.first().toUpperCase() }.forEach { Log.d("log", "  数据分组后" + it.toString()) }
        data.groupBy { it.first().toUpperCase() }
            .forEach { Log.d("log", "  数据分组后并把valus转为string" + it.value.joinToString()) }
        val numbers = linkedSetOf("one", "two", "three", "four", "five")
        Log.d("log", "  取出特定位置" + numbers.elementAt(3))
        Log.d("log", "  取出特定位置ull后的返回" + numbers.elementAtOrNull(5))
        Log.d("log", "  取出特定位置weinull后的默认值" + numbers.elementAtOrElse(5) { "666" })
        val numbersSortedSet = sortedSetOf("one", "two", "three", "four", "six")
        Log.d("log", "  取出特定位置" + numbersSortedSet.elementAt(2))
    }

    //遍历
    private fun testFive() {
        val data = listOf("one", "two", "three", "four")
        val dataAfter = data.filter { it.length > 3 }.forEach { Log.d("log", "长度大于三过滤后" + it.toString()) }
        val mapdata = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
        mapdata.filterKeys { it.endsWith("11") }.forEach { Log.d("log", "  map的key过滤后" + it.toString()) }
        mapdata.filterNot { (key, value) -> key.endsWith("1") && value > 10 }
            .forEach { Log.d("log", "  map的key 和valus过滤后" + it.toString()) }
    }

    //转换
    private fun testFour() {
        val numbers = setOf(1, 2, 3)
        //遍历map
        numbers.map { it * 2 }.forEach { Log.d("log", "遍历乘2得" + it.toString()) }
        numbers.mapIndexed { indx, values -> Log.d("log", "下表" + indx + "值" + values) }
        val numbers2 = setOf(1, 2, 3)
        //遍历map假如符合条件就跳过进行下一步
        numbers2.mapNotNull { if (it == 2) null else it * 3 }.forEach { Log.d("log", it.toString()) }
        numbers2.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx }
            .forEach { Log.d("log", it.toString()) }
        //zip组合
        val colors = listOf("red", "brown", "grey")
        val animals = listOf("fox", "bear", "wolf")
        colors.zip(animals).forEach { Log.d("log", "zip组合" + it.toString()) }
        val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
        numberPairs.unzip().first.forEach { Log.d("log", "unzip解开组合第一组" + it.toString()) }
        numberPairs.unzip().second.forEach { Log.d("log", "unzip解开组合第er组" + it.toString()) }
        val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
        numberSets.flatten().forEach { Log.d("log", "整合并打印" + it.toString()) }
        val containers = listOf(
            (listOf("one", "two", "three")),
            (listOf("four", "five", "six")),
            (listOf("seven", "eight"))
        )
        containers.forEach { Log.d("log", "整合并打印" + it.toString()) }
        containers.forEach { Log.d("log", "整合后成为list并转为string" + it.joinToString { it.toString() }) }
    }


    //序列操作
    private fun testThree() {
        var mutList = mutableListOf<String>()
        Log.d("log", " filter过滤后装填到另一个lsit")
        numbers.filterTo(mutList) { it.length > 3 }.forEach { Log.d("log", it.toString()) }
        Log.d("log", " filterIndexed双重进行过滤")
        numbers.filterIndexed { index, s -> index < 2 && s.equals("two") }.forEach { Log.d("log", it.toString()) }
        Log.d("log", " filter过滤后装填到另一个lsit")
        numbers.filterIndexedTo(mutList) { index, _ -> index == 1 }.forEach { Log.d("log", it.toString()) }
    }

    //序列
    private fun testTwo() {
        Log.d("log", " asSequence()字符串转为list工具")
        words.asSequence().forEach { Log.d("log", it.toString()) }
        Log.d("log", " split字符串转为去掉空格")
        words.split(" ").asSequence().forEach { Log.d("log", it.toString()) }
        Log.d("log", " filter字符串过滤")
        words.split(" ").asSequence().filter { it.length > 3 }.forEach { Log.d("log", it.toString()) }
        Log.d("log", " take字符串取出最前面的三个")
        words.split(" ").asSequence().filter { it.length > 3 }.take(3).forEach { Log.d("log", it.toString()) }
    }

    //区间与数列
    private fun testOne() {
        for (i in 1..10) Log.d("log", i.toString());Log.d("log", "打印一到十或者执行打印一到十")
        for (i in 10 downTo 1) Log.d("log", i.toString()); Log.d("log", "打印史道义 一次打印")
        for (i in 10 downTo 1 step 2) Log.d("log", i.toString()); Log.d("log", "打印史道义 隔两个打印")
        for (i in 1 until 10) Log.d("log", i.toString()); Log.d("log", "打印一到十或者执行打印一到十")
    }
}