package io.supertokens.javalin;

import com.google.gson.JsonObject;
import io.javalin.http.Context;
import io.supertokens.javalin.core.exception.GeneralException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SessionBuilder {

    @NotNull
    private final Context ctx;

    @NotNull
    private final String userId;

    @NotNull
    private JsonObject jwtPayload = new JsonObject();

    @NotNull
    private JsonObject sessionData = new JsonObject();

    SessionBuilder(@NotNull Context ctx, @NotNull String userId) {
        this.ctx = ctx;
        this.userId = userId;
    }

    public void withJWTPayload(@NotNull JsonObject jwtPayload) {
        this.jwtPayload = jwtPayload;
    }

    public void withSessionData(@NotNull JsonObject sessionData) {
        this.sessionData = sessionData;
    }

    public Session create() throws GeneralException {
        return SuperTokens.createNewSession(this.ctx, this.userId, this.jwtPayload, this.sessionData);
    }
}
