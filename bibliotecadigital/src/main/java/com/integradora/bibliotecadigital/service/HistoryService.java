package com.integradora.bibliotecadigital.service;

import org.springframework.stereotype.Service;

import com.integradora.bibliotecadigital.model.HistoryAction;
import com.integradora.bibliotecadigital.structures.ArrayStack;

@Service
public class HistoryService {

    private ArrayStack<HistoryAction> stack = new ArrayStack<>(100);

    public ArrayStack<HistoryAction> getStack() {
        return stack;
    }

    public void push(HistoryAction action) {
        stack.push(action);
    }

    public HistoryAction pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
