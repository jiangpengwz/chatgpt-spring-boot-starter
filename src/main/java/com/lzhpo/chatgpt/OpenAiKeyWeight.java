/*
 * Copyright 2023 lzhpo
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

package com.lzhpo.chatgpt;

import java.util.Collections;
import java.util.List;
import lombok.Data;

/**
 * @author lzhpo
 */
@Data
public class OpenAiKeyWeight {

    /**
     * This api key.
     */
    private String key;

    /**
     * This api key weight.
     * -1 表示不参与权重
     */
    private double weight;

    /**
     * Whether enable this api key.
     */
    private boolean enabled = true;

    /**
     * 哪些用户可用这个key。不设置、为空表示均可用。
     */
    private List<String> users = Collections.emptyList();

    public boolean matchKey(String user) {
        return users.contains(user);
    }

    /**
     * 不参与权重轮训
     */
    public boolean noWeight() {
        return weight == -1;
    }
}
