package com.angdroid.minoslaboratory.di.main

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type
import javax.inject.Inject


class FlowConverterFactory @Inject constructor(
    private val kotlinSerializationConverterFactory: Converter.Factory
) : Converter.Factory() {
    override fun requestBodyConverter(type: Type, parameterAnnotations: Array<out Annotation>, methodAnnotations: Array<out Annotation>, retrofit: Retrofit): Converter<*, RequestBody>? {
        return kotlinSerializationConverterFactory.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
    }

    override fun responseBodyConverter(type: Type, annotations: Array<out Annotation>, retrofit: Retrofit): Converter<ResponseBody, *>? {
        return kotlinSerializationConverterFactory.responseBodyConverter(type, annotations, retrofit)
    }
}
