package demo;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferencesDemo {

	public static void main(String[] args) throws BackingStoreException {
		// 系统级设定
//		Preferences.systemNodeForPackage(PreferencesDemo.class);

		// 用户级设定
		Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
		prefs.put("Location", "梁山");
		prefs.put("花和尚", "鲁智深");
		prefs.putInt("梁山好汉", 108);
		prefs.putBoolean("诏安", true);
		int usageCount = prefs.getInt("讨伐方腊", 0);
		usageCount++;
		prefs.putInt("讨伐方腊", usageCount);
		for (String key : prefs.keys()) {
			System.out.println(key + ": " + prefs.get(key, null));
		}

		System.out.println("讨伐方腊几次：");
		System.out.println(prefs.getInt("讨伐方腊", 0));

	}

}
