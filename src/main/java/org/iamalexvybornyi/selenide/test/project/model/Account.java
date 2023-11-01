package org.iamalexvybornyi.selenide.test.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Account {

    @NonNull
    private final String displayName;

    @NonNull
    private final String email;

    @NonNull
    private final String password;
}
