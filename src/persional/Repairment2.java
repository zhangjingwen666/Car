package persional;

/**
     * 维修实体类
     */
    public class Repairment2 {

        private int id; //id主键
        private String date_time;//时间
        private String repair_address;//维修地址
        private String repair_project;//维修项目
        private float cost;//费用
        private String responsible;//负责人工号
        private int car_id;//车辆ID

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDate_time() {
            return date_time;
        }

        public void setDate_time(String date_time) {
            this.date_time = date_time;
        }

        public String getRepair_address() {
            return repair_address;
        }

        public void setRepair_address(String repair_address) {
            this.repair_address = repair_address;
        }

        public String getRepair_project() {
            return repair_project;
        }

        public void setRepair_project(String repair_project) {
            this.repair_project = repair_project;
        }

        public float getCost() {
            return cost;
        }

        public void setCost(float cost) {
            this.cost = cost;
        }

        public String getResponsible() {
            return responsible;
        }

        public void setResponsible(String responsible) {
            this.responsible = responsible;
        }

        public int getCar_id() {
            return car_id;
        }

        public void setCar_id(int car_id) {
            this.car_id = car_id;
        }

        public Repairment2() {
        }

        public Repairment2(int id,String date_time,String repair_address, String repair_project,Float cost,String responsible,
                         int car_id) {
            this.id = id;
            this.date_time = date_time;
            this.repair_address = repair_address;
            this.repair_project = repair_project;
            this.cost=cost;

        }
        @Override
        public String toString() {
            return "Repair{" +
                    "id=" + id +
                    ", date_time='" + date_time + '\'' +
                    ", repair_address='" + repair_address + '\'' +
                    ", repair_project='" + repair_project + '\'' +
                    ", cost='" + cost + '\'' +
                    ", car_id='" + car_id + '\'' +
                    ", responsible='" + responsible + '\'' +
                    '}';
        }
    }
