public enum TipoDatos {


        INT(1), LONG(2), STRING(3), DOUBLE(4), FLOAT(5), DATE(6), CHAR(7);

        private final int value;
        private TipoDatos(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

