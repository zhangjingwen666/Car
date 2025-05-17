package persional;

    /**
     * 部门实体类
     */
    class Department {
        private int id;//id主键



        private String name;//部门名称
        private String manager_num;//主管人工号
        private String telephone;//部门电话



        public Department() {
        }

        public Department(int id, String name, String manager_num,  String telephone) {
            this.id = id;
            this.name = name;
            this.manager_num = manager_num;
            this.telephone = telephone;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getManager_num() {
            return manager_num;
        }

        public void setManager_num(String manager_num) {
            this.manager_num = manager_num;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }


        @Override
        public String toString() {
            return "Department{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", manager_num='" + manager_num + '\'' +
                    ", telephone='" + telephone + '\'' +
                    '}';
        }
    }
