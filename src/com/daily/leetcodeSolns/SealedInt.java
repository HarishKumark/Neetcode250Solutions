package com.daily.leetcodeSolns;

public sealed interface SealedInt permits Approved, Declined {
}

record Approved(String id) implements SealedInt {
}

record Declined(String reason) implements SealedInt {
}
