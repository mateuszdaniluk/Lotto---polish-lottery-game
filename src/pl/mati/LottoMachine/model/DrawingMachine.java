package pl.mati.LottoMachine.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DrawingMachine {

	private int numOfResults;
	private int numOfPossibiles;
	private int numOfRepetition;

	private ArrayList<Integer> results;
	private ArrayList<Integer> list;

	private Map<Integer, Integer> drawMap;
	private Map<Integer, Integer> resultMap;

	
	/*
	 * the DrawingMachine constructor. 
	 * 
	 * @param  nResults number of result in lottery game
	 * @param  nPossibilies number of possible number to draw in the game (all number avalible)
	 * @param  nRepetition how many repetiotion of the drawing JVM must perform 
	 * 
	 */
	public DrawingMachine(int nResults, int nPossibiles, int nRepetition) {
		this.numOfResults = nResults;
		this.numOfPossibiles = nPossibiles;
		this.numOfRepetition = nRepetition;

		list = createListOfNum(numOfPossibiles);
		results = createEmptyResultsList(numOfResults);
		drawMap = buildMap(numOfPossibiles);
	}

	/*
	 * method that create list of avalible Numbers in the lotteryGame. 
	 * 
	 * @param  listSize how many numbers is in the "drawing Machine
	 * @return      the ArrayList object. - list
	 * 
	 */
	private ArrayList<Integer> createListOfNum(int listSize) {
		ArrayList<Integer> list = new ArrayList<Integer>(listSize);
		for (int i = 1; i <= listSize; i++) {
			list.add(i);
		}

		return list;
	}

	/*
	 * method that creates empty(yet!) list of results in single lotteryGame. 
	 * 
	 * @param  listSize - only the results 
	 * @return      the ArrayList object. - resultsList
	 * 
	 */
	private ArrayList<Integer> createEmptyResultsList(int listSize) {
		ArrayList<Integer> results = new ArrayList<Integer>(listSize);

		return results;
	}

	/*
	 * method that creates a Map. In this Map DrawingMAchine contain the history of performed draws. 
	 * 
	 * @param  mapSize - all the avalible numbers/ 
	 * @return      the Map object.
	 * 
	 */
	private Map<Integer, Integer> buildMap(int mapSize) {
		drawMap = new HashMap<>(mapSize);
		for (int i = 1; i <= mapSize; i++) {
			drawMap.put(i, 0);
		}
		return drawMap;
	}
	/*
	 * method that perform single LotteryGame. It randomly pick a few numbers from all avalibles. 
	 * 
	 * @param  num - number of results 
	 * @return      the resultsList object. 
	 * 
	 */
	private ArrayList<Integer> pickNumbers(int num) {
		results.clear();
		Collections.shuffle(list);

		list.stream().limit(num).forEach(e -> {
			results.add(e);
		});

		return results;

	}

	/*
	 * method that sort a Map (history of all performed drawing. It sorts keys (numbers) and values (how many times each number was picked) in descending order.
	 * 
	 */
	private void sortMap() {
		resultMap = new LinkedHashMap<Integer, Integer>();
		resultMap = MapSortComparator.sortByValue(drawMap);
	}

	
	/*
	 * method that perform the lottery and generate all drawing.
	 * 
	 */
	public void startLottery() {
		int repeats = 1;

		while (repeats < numOfRepetition) {

			pickNumbers(numOfResults);

			results.forEach(e -> {
				drawMap.put(e, drawMap.get(e) + 1);
			});

			repeats++;
			results.clear();
		}

		sortMap();

		resultMap.forEach((key, value) -> {
			System.out.println("Number: " + key + "\t" + " Was drawn: " + value
					+ " times." + " Percentage: " + ((float)100 * value	/ numOfRepetition) + "%");
		});

	}
}
