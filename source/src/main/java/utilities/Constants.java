package utilities;

public final class Constants {

    public static final class directions {
        public static final int UP = 0;
        public static final int LEFT = 1;
        public static final int DOWN = 2;
        public static final int RIGHT = 3;
    }


    public static final class PlayerConstants {
        public static final int IDLE = 0;
        public static final int RUN = 1;
        public static final int JUMP = 2;
        public static final int FALL = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK_01 = 6;
        public static final int ATTACK_JUMP_01 = 7;
        public static final int ATTACK_JUMP_02 = 8;

        public static int getSpriteAmount(final int playerAction) {
            return switch (playerAction) {
                case RUN -> 6;
                case IDLE -> 5;
                case HIT -> 4;
                case JUMP, ATTACK_01,ATTACK_JUMP_01, ATTACK_JUMP_02 -> 3;
                case GROUND -> 2;
                case FALL -> 1;
                default -> throw new IllegalStateException("Unexpected value: " + playerAction);
            };
        }

    }

}
