package com.example.algorithm.goorm

import junit.framework.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

/**
 * Created by <a href="mailto:aucd29@hanwha.com">Burke Choi</a> on 2019-12-26 <p/>
 */

class C01 {
    @Test
    fun ex01() {
        val a = 10
        val b = 20
        val res = max(a, b)

        println("res = $res")

        assertEquals(max(a, b), b)
        assertNotEquals(max(a, b), a)
    }

    fun max(a: Int, b: Int) =
        if (a > b) a else b

    @Test
    fun ex02() {
        val arr = arrayOf(1, 4, 5, 6,7, 10, 20)
        val max = arr.max()

        println("res = $max")

        assertEquals(max, 20)
    }

    @Test
    fun ex03() {
        val mizu = 164
        val zisu = 159
        val arr  = arrayOf(154, 160, 159, 166, 164, 159, 170)
        var count = 0

        arr.forEach {
            when (it) {
                mizu, zisu -> ++count
            }
        }

        println("res = $count")

        assertEquals(count, 3)
    }

    @Test
    fun ex04() {
        val arr  = arrayOf(154, 160, 159, 166, 164, 159, 170)
        val res = arr.sum()

        println("sum = $res")

        assertEquals(res, 1132)
    }

    @Test
    fun ex05() {
        val members = arrayOf(60, 66, 80, 100, 70, 68)
        val userLimit = 80
        val deviceLimit = 400
        var sum = 0
        var count = 0

        members.forEach {
            if (userLimit >= it && deviceLimit > sum) {
                ++count
                sum += it
            }
        }

        println("sum   = $sum")
        println("count = $count")

        assertEquals(60+66+80+70+68, sum)
        assertEquals(5, count)
    }

    @Test
    fun ex06() {
        val arr = arrayOf(60, 66, 80, 100, 70, 68)
        var i = 0
        val map = arr.map { it to i++ }.toMap()
        var res = map[100]?.let { it } ?: -1

        println("res = $res")
        assertEquals(3, res)

        res = map[150]?.let { it } ?: -1
        println("res = $res")
        assertEquals(-1, res)
    }

    @Test
    fun ex07() {
        val AJOU = "AJOU"
        var arr = arrayOf(AJOU, "", "", "", "", "", AJOU, "", "", "", "", "")
        var f = arr.indexOf(AJOU)
        var e = arr.lastIndexOf(AJOU)
        println("f : $f, e : $e")
        assertEquals(f, 0)
        assertEquals(e, 6)

        arr = arrayOf("", "", "", "", "", AJOU, "", "", "", "", "", AJOU, "", "", "", "", "")
        f = arr.indexOf(AJOU)
        e = arr.lastIndexOf(AJOU)
        println("f : $f, e : $e")
        assertEquals(f, 5)
        assertEquals(e, 11)

        arr = arrayOf("", "", "", "", "", "", "", "", "", "", AJOU, "", "", "", "", "")
        f = arr.indexOf(AJOU)
        e = arr.lastIndexOf(AJOU)
        println("f : $f, e : $e")
        assertEquals(f, 10)
        assertEquals(e, 10)
    }

    @Test
    fun ex08() {
        val arr = arrayOf(60, 66, 80, 100, 68, 78, 70)
        val avg = arr.sum() / arr.size
        println("avg = $avg")
        var near = 0
        var min = Integer.MAX_VALUE

        arr.sort()
        arr.forEach {
            val a = Math.abs(it - avg)
            if (min > a) {
                min = a
                near = it
            }
        }

        println("near = $near")
        assertEquals(70, near)
    }

    @Test
    fun ex09() {
        val arr = arrayOf(60, 66, 80, 1, 100, 78, 70)
        val min = arr.min()
        val pos = arr.withIndex().minBy { it.value }?.index

        println("min = $min, pos = $pos")
        assertEquals(3, pos)
    }

    @Test
    fun ex10() {
        val n = 10
        val res = (1..n).sum()

        println("1..$n = $res")
        assertEquals(55, res)
    }
}