package case03;


import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class PhonePlan {
	private Double CallMin;
	private Double InternetMin;
	
	static class PhoneRule{
		private String type;
		private String description;
		private BiPredicate<Double, Double> condition;
		
		public PhoneRule(String type , String description , BiPredicate<Double, Double> condition) {
			this.type =type;
			this.description =description;
			this.condition=condition;
			
		}
		
		public boolean matches(Double CallMin , Double InternetMin) {
			return condition.test(CallMin , InternetMin);
		}
		
		public String getResult() {
			return type +"：" + description;
		}
		
	}
	//此寫法可以動態增加資料
	private static final List<PhoneRule> rules = new ArrayList<>();
	
	
	static {
		rules.add(new PhoneRule("商務型($1499)", "通話 > 1000 分鐘 or 流量 > 50 GB", (CallMin, InternetMin) ->CallMin>1000 || InternetMin >50 ));
		rules.add(new PhoneRule(" 一般用戶型($660)", "通話 > 500 分鐘 and 流量", (CallMin, InternetMin ) ->CallMin>500 || InternetMin >10));
		rules.add(new PhoneRule("長輩節省型($200)", "流量 < 1 GB and 通話 < 200 分鐘", (CallMin, InternetMin ) ->CallMin<200 || InternetMin <1));
		

	}
	
	public PhonePlan(Double CallMin , Double InternetMin){
		this.CallMin = CallMin;
		this.InternetMin=InternetMin;
		
		
	}
	
	public PhonePlan(String CallMin , String InternetMin){
		this(Double.parseDouble(CallMin), Double.parseDouble(InternetMin));
		
		
	}
	
	public String getPhoneType() {
		return rules.stream()
				.filter(rules -> rules.matches(CallMin, InternetMin))
				.findFirst()
				.map(PhoneRule::getResult)
				.orElse("無法辨識手機方案類型");
		
	}
	
	public Double getCallMin() {
		return CallMin;
	}
	
	public Double getInternetMin() {
		return InternetMin;
		
	}
}

