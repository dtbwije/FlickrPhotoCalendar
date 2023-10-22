package org.photolib.photolibrary

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PhotolibraryApplication

fun main(args: Array<String>) {
	runApplication<PhotolibraryApplication>(*args)
}
