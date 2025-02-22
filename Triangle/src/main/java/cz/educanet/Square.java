package cz.educanet;

import java.util.ArrayList;

public class Square {

	String gridValues = "101111111000111011101010000001" +
			"100000101101101100111011111111" +
			"110011100111000110100010000100" +
			"010110000000010010101110110111" +
			"011100111101110110111010100001" +
			"100011100111001100100000111011" +
			"100000100010011000101111101010" +
			"110011101110010111111000000010" +
			"010110100001110000001010111010" +
			"111100101111001111011010101011" +
			"001000001000001010010110101001" +
			"111011101011101011110100101101" +
			"101010101010111000001110100111" +
			"100010111010000111001010100001" +
			"111110000011001101011010101101" +
			"100100111101011001110001101001" +
			"101100100101000011011011001001" +
			"011001100101111010010010001011" +
			"110111001110001110110110011010" +
			"100100111011100010101100110010" +
			"100100000000111010101011101011" +
			"101111011110001011001010001001" +
			"100001010011001001101011001101" +
			"110011011101101100101001111001" +
			"011010000100100110101011001001" +
			"001011001101100010001000011001" +
			"111001111001011010111011110011" +
			"010000100001010011100010001110" +
			"011110001111010000000111001000" +
			"110011111001011111111101111111";

	String[] singleValues = gridValues.split("");
	ArrayList<Float> vertices = new ArrayList<>();

	public Square() {
		int position = 0;
		float elementsPerSide = (float) Math.sqrt(singleValues.length);
		float elementSideLength = (float) (2/elementsPerSide);
		float topY = 1;
		float bottomY = 1 - elementSideLength;
		float rightX = -1 + elementSideLength;
		float leftX = -1;
		for(float row = 0; row < elementsPerSide; row++){
			for(float column = 0; column < elementsPerSide; column++){
				if (singleValues[position].equals("0")){
					insertVertex(leftX,topY);//top left
					insertVertex(rightX,topY);//top right
					insertVertex(leftX,bottomY);//bottom left

					insertVertex(rightX,topY);//top right
					insertVertex(rightX,bottomY);//bottom right
					insertVertex(leftX,bottomY);//bottom left

				}
				position++;
				leftX += elementSideLength;
				rightX += elementSideLength;
			}
			rightX = -1 + elementSideLength;
			leftX = -1;
			topY -= elementSideLength;
			bottomY -= elementSideLength;
		}

	}

	public void insertVertex(float xVal, float yVal){
		vertices.add(xVal);
		vertices.add(yVal);
		vertices.add(0f);
	}

	public ArrayList<Float> getSquareVertices(){
		return vertices;
	}
}
