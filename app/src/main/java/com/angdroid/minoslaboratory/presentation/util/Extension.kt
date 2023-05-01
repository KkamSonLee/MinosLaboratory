package com.angdroid.minoslaboratory.presentation.util

import java.time.LocalDateTime
import java.time.ZoneId

fun LocalDateTime.toMillis(zone: ZoneId = ZoneId.systemDefault()) = atZone(zone)?.toInstant()?.toEpochMilli()