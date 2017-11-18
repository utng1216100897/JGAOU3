package jgao.model;
import java.io.Serializable;

	public class Die implements Serializable{
		private Long id;
		private Long age;
		private String service ;
		private String enter_date;
		private String die_date;
		private String result;
		public Die(Long id, Long age, String service, String enter_date, String die_date, String result) {
			super();
			this.id = id;
			this.age = age;
			this.service = service;
			this.enter_date = enter_date;
			this.die_date = die_date;
			this.result = result;
		}
		
		public Die() {
			this(0L,0L,"","","","");
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getAge() {
			return age;
		}

		public void setAge(Long age) {
			this.age = age;
		}

		public String getService() {
			return service;
		}

		public void setService(String service) {
			this.service = service;
		}

		public String getEnter_date() {
			return enter_date;
		}

		public void setEnter_date(String enter_date) {
			this.enter_date = enter_date;
		}

		public String getDie_date() {
			return die_date;
		}

		public void setDie_date(String die_date) {
			this.die_date = die_date;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

		@Override
		public String toString() {
			return "Die [id=" + id + ", age=" + age + ", service=" + service + ", enter_date=" + enter_date
					+ ", die_date=" + die_date + ", result=" + result + "]";
		}
		
		
		
		
		
		
		
	}


