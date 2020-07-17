/*
 * Copyright (C) guolin, Suzhou Quxiang Inc. Open source codes for study only.
 * Do not use for commercial purpose.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cy.applibrary.commonui.exception

/**
 * 当服务器响应的头不在200与300之间时，说明请求出现了异常，此时应该将此异常主动抛出。
 *
 * @author guolin
 * @since 17/2/13
 */
class ResponseCodeException(val responseCode: Int) : RuntimeException("Http request failed with response code $responseCode")
