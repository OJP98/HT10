private static class Vertex {
        private E uniqueLabel;

        public Vertex(E uniqueLabel) {
            super();
            this.uniqueLabel = uniqueLabel;
        }

        @Override
        public boolean equals(Vertex obj) {
            if (this == obj) return true;
            if (!(obj instanceof Vertex)) return false;

            Vertex _obj = (Vertex) obj;
            return _obj.uniqueLabel == uniqueLabel;
        }

        public E getLabel() {
            return uniqueLabel;
        }

        public void setLabel(E uniqueLabel) {
            this.uniqueLabel = uniqueLabel;
        }
    }
