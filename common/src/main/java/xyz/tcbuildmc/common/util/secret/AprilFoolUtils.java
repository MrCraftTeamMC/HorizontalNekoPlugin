package xyz.tcbuildmc.common.util.secret;

import java.time.LocalDate;
import java.time.LocalTime;

public final class AprilFoolUtils {
    private static final LocalDate AprilFoolDate = LocalDate.of(
            LocalDate.now().getYear(), 4, 1);
    private static final LocalTime AprilFoolTime = LocalTime.of(
            11, 45, 14, 1919810);

    public static boolean isTodayAprilFool() {
        return LocalDate.now().isEqual(AprilFoolDate);
    }

    public static boolean isNowAprilFoolTime() {
        return LocalTime.now().equals(AprilFoolTime);
    }
}
