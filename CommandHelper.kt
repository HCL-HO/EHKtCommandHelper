package com.eh.kotlin.commandhelperkt

import java.lang.StringBuilder

class CommandHelper {
    companion object {
        fun waitInput(msg: String): String {
            println(msg)
            val input = readLine()
            return input ?: ""
        }

        fun waitNumber(msg: String, default: Int = 0): Int {
            println(msg)
            val input = readLine()?.toIntOrNull()
            return input ?: default
        }

        fun chooseOne(mails: Collection<String>): String {
            val sb = StringBuilder()
            mails.forEachIndexed { index, s ->
                sb.append("${index}: $s  ")
            }
            println(sb.toString())
            var index = readLine()?.toIntOrNull()
            while (index == null || index > mails.size - 1) {
                println(sb.toString())
                index = readLine()?.toIntOrNull()
            }
            return mails.elementAt(index)
        }

        fun chooseMany(msg: String = "", mails: Collection<String>): Collection<String> {
            if (msg.isNotEmpty()) println("$msg Press Enter When Finished")
            val chosen = HashSet<String>()
            val sb = StringBuilder()
            mails.forEachIndexed { index, s ->
                sb.append("${index}: $s  ")
            }
            println(sb.toString())
            var index = readLine()?.toIntOrNull()
            while (index != null) {
                if (index < mails.size) {
                    chosen.add(mails.elementAt(index))
                }
                println(sb.toString())
                index = readLine()?.toIntOrNull()
            }
            return chosen
        }

        fun chooseMany(mails: Collection<String>): Collection<String> {
            return chooseMany("", mails)
        }

        fun waitBoolean(s: String): Boolean {
            println("$s (Y/N)")
            val input = readLine()
            return input.equals("Y", true)
        }
    }
}