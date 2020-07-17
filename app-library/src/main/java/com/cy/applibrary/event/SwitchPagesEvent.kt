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

package com.cy.applibrary.event

import com.cy.applibrary.event.MessageEvent

/**
 * EventBus通知Tab页切换界面。
 *
 * @author vipyinzhiwei
 * @since  2020/5/19
 */
open class SwitchPagesEvent(var activityClass: Class<*>? = null) : MessageEvent()