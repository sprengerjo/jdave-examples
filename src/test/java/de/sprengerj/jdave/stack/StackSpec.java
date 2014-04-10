package de.sprengerj.jdave.stack;

import java.util.Stack;

import jdave.Block;
import jdave.Specification;
import jdave.junit4.JDaveRunner;

import org.junit.runner.RunWith;

@RunWith(JDaveRunner.class)
public class StackSpec extends Specification<Stack<?>> {
    
	public class EmptyStack {
        private Stack<String> stack;

        public Stack<String> create() {
            stack = new Stack<String>();
            return stack;
        }

        public void isEmpty() {
            specify(stack, must.be.empty());
        }

        public void isNoLongerEmptyAfterPush() {
            stack.push("anything");
            specify(stack, must.not().be.empty());
        }
    }

    public class FullStack {
        private Stack<Integer> stack;

        public Stack<Integer> create() {
            stack = new Stack<Integer>();
            for (int i = 0; i < 10; i++) {
                stack.push(i);
            }
            return stack;
        }


        public void complainsOnGetInvalidIndex() {
            specify(new Block() {
                public void run() throws Throwable {
                    stack.get(1000);
                }
            }, should.raise(ArrayIndexOutOfBoundsException.class));
        }
        
        public void containsAllItems() {
            for (int i = 0; i < 10; i++) {
                specify(stack, contains(i));
            }
        }
        
        public void doesNotContainRemovedItem() {
            stack.remove(3);
            specify(stack, does.not().contain(3));
        }
        
        public void containsAllButRemovedItem() {
            stack.remove(3);
            specify(stack, containsExactly(0, 1, 2, 4, 5, 6, 7, 8, 9));
        }
    }

    public class StackWhichIsNeitherEmptyNorFull {
        private Stack<Integer> stack;

        public Stack<Integer> create() {
            stack = new Stack<Integer>();
            for (int i = 0; i < 10; i++) {
                stack.push(i);
            }
            return stack;
        }

        public void addsToTheTopWhenSentPush() {
            stack.push(100);
            specify(stack.peek(), must.equal(100));
        }
    }
}