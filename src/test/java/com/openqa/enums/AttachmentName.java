package com.openqa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AttachmentName {
    SEARCH("search"),
    LOOKUP("lookup");
    private String attachmentName;
}
