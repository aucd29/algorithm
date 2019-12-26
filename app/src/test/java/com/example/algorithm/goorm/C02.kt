package com.example.algorithm.goorm

import android.graphics.Point
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Test

/**
 * Created by <a href="mailto:aucd29@hanwha.com">Burke Choi</a> on 2019-12-26 <p/>
 */

class C02 {
    @Test
    fun ex01() {
        // 원하는 월에 값을 얻어야 함
        // 원하는 월의 데이터가 없으면 -1 반환

        val arrHeight  = arrayOf(154, 160, 159, 166, 164, 159, 170)
        val arrMonth = arrayOf(1, 4, 3, 4, 5, 6, 7)

        var i = 0
        val size = arrHeight.size
        val month = 4
        var maxHeight = 0

        while (i < size) {
            if (arrMonth[i] == month) {
                // 기준 달에 최대 값을 구함
                if (maxHeight < arrHeight[i]) {
                    maxHeight = arrHeight[i]
                }
            }

            ++i
        }

        println("max height : $maxHeight")
        assertEquals(166, maxHeight)
    }

    @Test
    fun ex02() {
        // 주어진 배열이 오름차순인지 확인
        val arr = arrayOf(154, 160, 161, 166, 164, 159, 170)
        println("default : ${arr.contentToString()}")
        println("isOrder : ${isOrdered(arr) }")

        val high = arr.sortedArray()
        println("high : ${high.contentToString()}")
        println("isOrder : ${isOrdered(high) }")

        val low = arr.sortedArrayDescending()
        println("low : ${low.contentToString()}")
        println("isOrder : ${isOrdered(low) }")
    }

    private fun isOrdered(arr: Array<Int>): Boolean {
        var old = 0
        var res = true
        arr.forEach {
            if (it > old) {
                old = it
            } else {
                res = false
                return@forEach
            }
        }

        return res
    }

    @Test
    fun ex03() {
        // 중복을 제외한 숫자의 종류의 수를 계산
        val arr = arrayOf(154, 160, 160, 166, 164, 159, 170)
        val map = arr.map { it to null }.toMap()

        println("count : ${map.size}")
        assertEquals(6, map.size)
    }

    @Test
    fun ex04() {

    }

    @Test
    fun ex05() {
        // 프라임 값 유/무 확인
        var res = isPrime(29)
        println("29 is a prime number $res")
        assertTrue(res)

        res = isPrime(30)
        println("30 is a prime number $res")
    }

    private fun isPrime(num: Int): Boolean {
        var flag = false
        for (i in 2..num / 2) {
            if (num % i == 0) {
                flag = true
                break
            }
        }

        return !flag
    }

    @Test
    fun ex06() {
        // sqrt 제곱근 (루트)
        // 주어진 점중 가장 최소 거리를 생성 한다.

        val points = arrayOf<Point2D>(Point2D(10, 1),
            Point2D(10, 10),
            Point2D(650, 100),
            Point2D(20, 100),
            Point2D(1, 70),
            Point2D(90, 1))

        var minSqd = Integer.MAX_VALUE
        var minCnt = 0
        var i = 0
        var j = 0

        while (i < points.size) {
            j = 0

            while (j < i) {
                val sqd = points[i].squaredDistanceTo(points[j])
                if (sqd < minSqd) {
                    // 최소 거리 갱신
                    minSqd = sqd
                    minCnt = 1
                } else if (sqd == minSqd) {
                    // 최소거리가 중복이라면 빈도수를 증가 시킨다.
                    ++minCnt
                }

                ++j
            }

            ++i
        }

        val distance = Math.sqrt(minSqd.toDouble())
        println("distance : $distance ($minCnt)")
    }

    data class Point2D(var x: Int, var y: Int) {
        fun squaredDistanceTo(target: Point2D): Int {
            val dx = Math.abs(target.x - x)
            val dy = Math.abs(target.y - y)

            return dx * dx + dy * dy
        }

        fun distanceTo(target: Point2D): Double {
            return Math.sqrt(squaredDistanceTo(target).toDouble())
        }
    }
}