package org.khpi.ai.model;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private final List<Integer> first;
    private final List<Integer> second;
    private final EntityData firstEntity;
    private final EntityData secondEntity;
    private final List<Integer> connectionWeights = new ArrayList<>();

    public Neuron(EntityData first, EntityData second) {
        System.out.println("Initializing neuron with symbols " + first.getSymbol() + " and " + second.getSymbol() + "...");

        if (first.getData().size() != second.getData().size()) {
            throw new IllegalStateException("Sizes cannot be different");
        }

        if (first.getSignal() == 1 && second.getSignal() == -1) {
            this.first = first.getData();
            this.second = second.getData();
            this.firstEntity = first;
            this.secondEntity = second;
        } else if (first.getSignal() == -1 && second.getSignal() == 1) {
            this.first = second.getData();
            this.second = first.getData();
            this.firstEntity = second;
            this.secondEntity = first;
        } else {
            throw new IllegalStateException("Signals must be 1 and -1");
        }

        System.out.println(first.getSymbol() + " data: " + first.getData());
        System.out.println(second.getSymbol() + " data: " + second.getData());

        connectionsAdjustment();

        System.out.print("Adjusted connection wights: ");
        for (int i = 0; i < connectionWeights.size(); i++) {
            System.out.print("W" + i + ":" + connectionWeights.get(i) + " ");
        }
        System.out.println();
        System.out.println();
    }

    public EntityData recognize(List<Integer> inputData) {
        System.out.println("Trying to recognize symbol between " + firstEntity.getSymbol() + "(" + firstEntity.getSignal() + ")" +
                " and " + secondEntity.getSymbol() + "(" + secondEntity.getSignal() + ")" + "...");
        System.out.println("Input data: " + inputData);

        int sum = 0;
        for (int i = 0; i < first.size(); i++) {
            sum += inputData.get(i) * connectionWeights.get(i);
        }

        System.out.println("Sum: " + sum);

        return sum > 0
                ? firstEntity
                : secondEntity;
    }

    private void connectionsAdjustment() {
        for (int i = 0; i < first.size(); i++) {
            connectionWeights.add(first.get(i) + Math.negateExact(second.get(i)));
        }
    }
}
