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

        val points = arrayOf(Point2D(10, 1),
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

        // 이게 답인지를 모르겠네? =_ =?ㅋ
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

    @Test
    fun ex07() {
        // 버블 소트
        val arr = arrayOf(154, 160, 160, 166, 164, 159, 170)
        val sorted = bubbleSort(arr)

        println("res : ${sorted.contentToString()}")
    }

    private fun bubbleSort(arr: Array<Int>): Array<Int> {
        // https://gmlwjd9405.github.io/2018/05/06/algorithm-bubble-sort.html
        // 인접한 2개의 레코드를 비교하여 크기가 순서대로 되어 있지 않으면 서로 교환한다.

        // 버블 정렬은 첫 번째 자료와 두 번째 자료를, 두 번째 자료와 세 번째 자료를, 세 번째와 네 번째를, …
        // 이런 식으로 (마지막-1)번째 자료와 마지막 자료를 비교하여 교환하면서 자료를 정렬한다.

        // 1회전을 수행하고 나면 가장 큰 자료가 맨 뒤로 이동하므로 2회전에서는 맨 끝에 있는 자료는 정렬에서 제외되고,
        // 2회전을 수행하고 나면 끝에서 두 번째 자료까지는 정렬에서 제외된다.
        // 이렇게 정렬을 1회전 수행할 때마다 정렬에서 제외되는 데이터가 하나씩 늘어난다.

        var i = arr.size - 1
        var j = 0
        var tmp = 0

        while (i > 0) {
            j = 0

            while (j < i) {
                // < = 큰 순서
                // > = 작은 순서
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = tmp
                }

                ++j
            }

            --i
        }

        return arr
    }

    @Test
    fun ex08() {
        // 좌표 값이 반지름 R 인 원에 포함되는지 ?

        val R = 100L
        var sum = 0L
        var y = R
        var x = 0L

        while (x <= R) {
            var height = 0L

            while (y >= 0) {
                if (isInside(x, y, R)) {
                    height = y + 1L
                    break
                }

                --y
            }

            sum += height
            ++x
        }

        println("pixel : ${sum * 4}")
    }

    private fun isInside(x: Long, y: Long, r: Long): Boolean {
        val sqd = x * x + y * y // 거리의 제곱
        if (sqd < r * r) {
            // 원점과의 거리가 반지름 보다 작으면 원안에 있는 것
            return true
        }

        return false
    }

    @Test
    fun test() {
        val num = 100 // readLine()?.toInt()!!
        var a = 1
        var result = ""
        while (a <= num) {
            if (num % a == 0) {
                result += "$a "
            }

            ++a
        }

        println("${result.trim()}\n")
    }
}