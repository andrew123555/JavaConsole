package case02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class Coffee {
	private Double milk;
	private Double coffee;
	
	static class CoffeeRule{
		private String type;
		private String description;
		private BiPredicate<Double, Double> condition;
		
		public CoffeeRule(String type , String description , BiPredicate<Double, Double> condition) {
			this.type =type;
			this.description =description;
			this.condition=condition;
			
		}
		
		public boolean matches(Double milk , Double coffee) {
			return condition.test(milk , coffee);
		}
		
		public String getResult() {
			return type +"：" + description;
		}
		
	}
	//此寫法可以動態增加資料
	private static final List<CoffeeRule> rules = new ArrayList<>();
	
	
	static {
		rules.add(new CoffeeRule("濃郁的拿鐵", "牛奶的比例遠高於咖啡，味道偏向牛奶。", (milk, coffee) ->milk >= 3*coffee));
		rules.add(new CoffeeRule("平衡的拿鐵咖啡", "牛奶與咖啡的比例較為平衡，風味溫和。", (milk, coffee ) ->milk >= 1.5*coffee));
		rules.add(new CoffeeRule("標準卡布奇諾", "牛奶與咖啡的比例恰到好處，典型的卡布奇諾。", (milk, coffee ) ->milk.equals(coffee)));
		rules.add(new CoffeeRule("濃縮咖啡", "咖啡的比例遠高於牛奶，口感濃烈，偏向純咖啡。", (milk, coffee ) ->coffee >= 3*milk));
		rules.add(new CoffeeRule("普通咖啡", "牛奶與咖啡的比例較為普通，適合日常飲用。", (milk, coffee ) ->true));

	}
	
	public Coffee(Double milk , Double coffee){
		this.milk = milk;
		this.coffee=coffee;
		
		
	}
	
	public Coffee(String milk , String coffee){
		this(Double.parseDouble(milk), Double.parseDouble(coffee));
		
		
	}
	
	public String getCoffeeType() {
		return rules.stream()
				.filter(rules -> rules.matches(milk, coffee))
				.findFirst()
				.map(CoffeeRule::getResult)
				.orElse("無法辨識咖啡類型");
		
	}
	
	public Double getMilk() {
		return milk;
	}
	
	public Double getCoffee() {
		return coffee;
		
	}
}
