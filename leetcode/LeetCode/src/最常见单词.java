//class Solution{
//	public String mostCommonWord(String paragraph, String[] banned){
//		Set<String> bannedSet = new HashSet<String>();
//		for(String s : banned){
//			bannedSet.add(s);
//		}
//		int maxFrequency = 0;
//        StringBuffer sb = new StringBuffer();
//		Map<String, Integer> frequencies = new HashMap();
//		for(int i = 0; i <= paragraph.length(); ++i){
//			if(i < paragraph.length() && Character.isLetter(paragraph.charAt(i))){
//				sb.append(Character.toLowerCase(paragraph.charAt(i)));
//			}else if(sb.length() > 0){
//				String word = sb.toString();
//				if(!bannedSet.contains(word)){
//					int frequency = frequencies.getOrDefault(word, 0)+1;
//					frequencies.put(word, frequency);
//					maxFrequency = Math.max(maxFrequency, frequency);
//				}
//				sb.setLength(0);
//			}
//		}
//		String mostCommon = "";
//		Set<Map.Entry<String, Integer>> entries = frequencies.entrySet();
//		for(Map.Entry<String, Integer> entry : entries){
//			String word = entry.getKey();
//			int frequency = entry.getValue();
//			if(frequency == maxFrequency){
//				mostCommon = word;
//				break;
//			}
//		}
//		return mostCommon;
//	}
//}