package com.example.gamecenter

import java.io.DataOutputStream

object RootShell {
    fun exec(command: String): String {
        try {
            val process = Runtime.getRuntime().exec(arrayOf("su", "-c", command))
            val os = DataOutputStream(process.outputStream)
            os.writeBytes(command + "\n")
            os.flush()
            os.close()
            process.waitFor()
            return process.inputStream.bufferedReader().readText()
        } catch (e: Exception) {
            return ""
        }
    }

    fun simulateTap(x: Int, y: Int) {
        exec("input tap $x $y")
    }

    fun simulateSwipe(x1: Int, y1: Int, x2: Int, y2: Int, duration: Int) {
        exec("input swipe $x1 $y1 $x2 $y2 $duration")
    }
}
