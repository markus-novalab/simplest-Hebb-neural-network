package org.khpi.ai;

import org.khpi.ai.model.EntityData;
import org.khpi.ai.model.Neuron;
import org.khpi.ai.model.Symbol;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityData mData = new EntityData(List.of(1, 0, 1, 1, 1, 1, 1, 0, 1), 1, Symbol.M);
        EntityData aData = new EntityData(List.of(0, 1, 1, 1, 1, 1, 1, 0, 1), -1, Symbol.A);
        EntityData rData = new EntityData(List.of(1, 1, 1, 1, 1, 1, 1, 0, 0), 1, Symbol.R);
        EntityData kData = new EntityData(List.of(1, 0, 1, 1, 1, 0, 1, 0, 1), -1, Symbol.K);

        Neuron neuronMA = new Neuron(mData, aData);
        Neuron neuronRK = new Neuron(rData, kData);

        System.out.println("Input: M");
        EntityData outputM = neuronMA.recognize(mData.getData());
        System.out.println("Found symbol: " + outputM.getSymbol());
        System.out.println();

        System.out.println("Input: A");
        EntityData outputA = neuronMA.recognize(aData.getData());
        System.out.println("Found symbol: " + outputA.getSymbol());
        System.out.println();

        System.out.println("Input: R");
        EntityData outputR = neuronRK.recognize(rData.getData());
        System.out.println("Found symbol: " + outputR.getSymbol());
        System.out.println();

        System.out.println("Input: K");
        EntityData outputK = neuronRK.recognize(kData.getData());
        System.out.println("Found symbol: " + outputK.getSymbol());
        System.out.println();
    }
}
