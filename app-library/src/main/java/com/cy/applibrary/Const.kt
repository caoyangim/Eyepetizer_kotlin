/*
 * Copyright (c) 2020. vipyinzhiwei <vipyinzhiwei@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cy.applibrary

/**
 * 项目所有全局通用常量的管理类。
 *
 * @author vipyinzhiwei
 * @since  2020/5/31
 */
interface Const {

    interface ActionUrl {
        companion object {

            const val TAG = "eyepetizer://tag/"

            const val DETAIL = "eyepetizer://detail/"

            const val RANKLIST = "eyepetizer://ranklist/"

            const val WEBVIEW = "eyepetizer://webview/?title="

            const val REPLIES_HOT = "eyepetizer://replies/hot?"

            const val TOPIC_DETAIL = "eyepetizer://topic/detail?"

            const val COMMON_TITLE = "eyepetizer://common/?title"

            const val LT_DETAIL = "eyepetizer://lightTopic/detail/"

            const val CM_TOPIC_SQUARE = "eyepetizer://community/topicSquare"

            const val HP_NOTIFI_TAB_ZERO = "eyepetizer://homepage/notification?tabIndex=0"

            const val CM_TAGSQUARE_TAB_ZERO = "eyepetizer://community/tagSquare?tabIndex=0"

            const val CM_TOPIC_SQUARE_TAB_ZERO = "eyepetizer://community/tagSquare?tabIndex=0"

            const val HP_SEL_TAB_TWO_NEWTAB_MINUS_THREE = "eyepetizer://homepage/selected?tabIndex=2&newTabIndex=-3"
        }
    }

    interface Toast {

        companion object {

            const val BIND_VIEWHOLDER_TYPE_WARN = "bindViewHolder Type Unprocessed"
        }
    }

    interface Url {

        companion object {

            const val AUTHOR_LOGIN = "http://open.eyepetizer.net/#!/login"

            const val AUTHOR_REGISTER = "http://open.eyepetizer.net/#!/register"

            const val FORGET_PASSWORD = "http://open.eyepetizer.net/#!/forget"

            const val USER_AGREEMENT = "http://www.eyepetizer.net/agreement.html"

            const val VIDEO_FUNCTION_STATEMENT = "http://www.eyepetizer.net/right.html"

            const val LEGAL_NOTICES = "http://www.kaiyanapp.com/legal_notices.html"

            const val AUTHOR_OPEN = "http://open.eyepetizer.net/#!/landing"
        }
    }

    interface Mobclick {

        companion object {

            const val EVENT1 = "10001"

            const val EVENT2 = "10002"

            const val EVENT3 = "10003"

            const val EVENT4 = "10004"

            const val EVENT5 = "10005"

            const val EVENT6 = "10006"

            const val EVENT7 = "10007"

            const val EVENT8 = "10008"

            const val EVENT9 = "10009"

        }
    }
}