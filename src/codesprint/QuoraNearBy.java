package codesprint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class QuoraNearBy {
	
//	private double distance(double lati1, double lati2, double lon1, double lon2) {
//		final double R = 6371; // km
//		final double dLat = Math.toRadians(lati2 - lati1);
//		final double dLon = Math.toRadians(lon2 - lon1);
//		final double lat1 = Math.toRadians(lati1);
//		final double lat2 = Math.toRadians(lati2);
//
//		final double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
//		final double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//		final double d = R * c;
//		return d;
//	}
	
	public class Topic {
		final int topicId;
		final double x;
		final double y;
		protected double presentMinDistance;
		
		public Topic(final int tId, final double x, final double y) {
			this.topicId = tId;
			this.x = x;
			this.y = y;
		}

//		public double distance(Topic target) {
//			final double dist = Math.sqrt(Math.pow(target.x - this.x, 2) + Math.pow(target.y - this.y, 2));
//			return dist;
//		}
		
		public double getDistance(double x, double y) {
			final double dist = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
			return dist;
		}
		
		public void setMinDistance(double x, double y) {
			presentMinDistance = getDistance(x, y); 
		}
		
		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder();
			sb.append("TopicId: " + topicId + "\n");
			sb.append("X: " + x + "\n");
			sb.append("Y: "  + y + "\n");
			return sb.toString();
		}
	}
	
	public class Question {
		final int questionId;
		final int[] topics;
		final int numTopics;
		public double presentMinDistance;
		
		public Question(final int qId, int[] topics) {
			this.questionId = qId;
			assert topics != null;
			this.numTopics = topics.length;
			this.topics = new int[numTopics];
			int idx = 0;
			for(int topic: topics) {
				this.topics[idx] = topic;
				++idx;
			}
		}	
		
		public void setMinDistance(double x, double y) {
			double minDistance = Double.MAX_VALUE;
			for(int topicId : topics) {
				final double dist = topicIdToTopic.get(topicId).getDistance(x, y);
				if(dist < minDistance) {
					minDistance = dist;
				}
			}
			presentMinDistance = minDistance;
		}
		
		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder();
			sb.append("QuestionId: " + questionId + "\n");
			sb.append("Topics: ");
			for(int i=0; i<numTopics; ++i) {
				sb.append(topics[i] + " ");
			}
			sb.append("\n");
			return sb.toString();
		}
	}
	
	final int numTopics;
	final int numQuestions;
	final int numQueries;
	final HashMap<Integer, Topic> topicIdToTopic;
	final HashMap<Integer, Question> questionIdToQuestion;
	
	public QuoraNearBy() throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		numTopics = Integer.parseInt(st.nextToken());
		numQuestions = Integer.parseInt(st.nextToken());
		numQueries = Integer.parseInt(st.nextToken());
		
		topicIdToTopic = new HashMap<Integer, Topic>(numTopics);
		for(int i=0; i<numTopics; ++i) {
			st = new StringTokenizer(br.readLine());
			final int topicId = Integer.parseInt(st.nextToken());
			final double x = Double.parseDouble(st.nextToken());
			final double y = Double.parseDouble(st.nextToken());
			topicIdToTopic.put(topicId, new Topic(topicId, x, y));
		}
		
		questionIdToQuestion = new HashMap<Integer, Question>(numQuestions);
		for(int i=0; i<numQuestions; ++i) {
			st = new StringTokenizer(br.readLine());
			final int qId = Integer.parseInt(st.nextToken());
			final int numTopics = Integer.parseInt(st.nextToken());
			if(numTopics > 0) {
				final int[] topics = new int[numTopics];
				int idx = 0;
				while(st.hasMoreTokens()) {
					topics[idx++] = Integer.parseInt(st.nextToken());
				}
				questionIdToQuestion.put(qId, new Question(qId, topics));
			}		
		}		
//		runQueries(br);
//		debug();
	}
	
	private void debug() {
		final Iterator topicIterator = topicIdToTopic.entrySet().iterator();
		while(topicIterator.hasNext()) {
			Entry et = (Entry)topicIterator.next();
			System.out.println(et.getKey() + ":" + et.getValue().toString());
		}
		
		final Iterator questionIterator = questionIdToQuestion.entrySet().iterator();
		while(questionIterator.hasNext()) {
			Entry et = (Entry)questionIterator.next();
			System.out.println(et.getKey() + ":" + et.getValue().toString());
		}
	}
	
	private void runQueries(final BufferedReader br) throws Exception {
		StringTokenizer st;				
		for(int i=0; i<numQueries; ++i) {
			st = new StringTokenizer(br.readLine());
			final boolean isQuestionRequired = st.nextToken().compareTo("q") == 0 ? true : false; 
			final int numResults = Integer.parseInt(st.nextToken());
			final double x = Double.parseDouble(st.nextToken());
			final double y = Double.parseDouble(st.nextToken());
			if(isQuestionRequired) {
				processQuestion(numResults, x, y);
			}
		}		
	}
	
	private void processQuestion(final int numResults, final double x, final double y) {
		PriorityQueue<Question> p = new PriorityQueue<Question>(numResults, new Comparator<Question>() {
			@Override
			public int compare(Question question1, Question question2) {
				if(question1.presentMinDistance < question2.presentMinDistance) {
					return -1;
				} 
				if(question1.presentMinDistance > question2.presentMinDistance) {
					
				}
				return 0;
			}
		});
		
		final Iterator questionIterator = questionIdToQuestion.entrySet().iterator();
		while(questionIterator.hasNext()) {
			Entry et = (Entry)questionIterator.next();			
		}
	}
	
	public static void main(String[] args) throws Exception {
		QuoraNearBy q = new QuoraNearBy();		
	}
}
