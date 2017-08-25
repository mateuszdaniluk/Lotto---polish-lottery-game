package pl.mati.LottoMachine.model;

public class LottoMachine {

	private int numOfDraws;

	private int nRes;
	private int nPos;

	
	/*
	 * the LottoMachine constructor. 
	 * 
	 * @param  nDraws how many repetiotion of the drawing JVM must perform
	 * @param  nOfResults number of result in lottery game
	 * @param  nOFPossibilies number of possible number to draw in the game (all number avalible)
	 *  
	 */
	public LottoMachine(int nDraws, int nOfResults, int nOfPossibilities) {
		this.numOfDraws = nDraws;
		this.nRes = nOfResults;
		this.nPos = nOfPossibilities;

		drawNumbers();
	}

	private void drawNumbers() {

		DrawingMachine lottoMachine = new DrawingMachine(nRes, nPos, numOfDraws);

		lottoMachine.startLottery();
	}

}
