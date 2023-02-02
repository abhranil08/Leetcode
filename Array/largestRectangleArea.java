class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int maxArea = 0, i = 0, area = 0;
        int topElement;

        while( i < heights.length )
        {
            if( st.empty() || heights[i] >= heights[st.peek()])
                st.push(i++);
            else
            {
                topElement = st.peek();
                st.pop();
                area = heights[topElement] * ( st.empty() ? i : i - st.peek() - 1 );
                maxArea = Math.max( area, maxArea );
                
            }
        }

        while( !st.isEmpty() )
        {
            topElement = st.peek();
            st.pop();
            area = heights[topElement] * ( st.empty() ? i : i - st.peek() - 1 );
            maxArea = Math.max( area, maxArea );
             
        }
        return maxArea;
        
    }
}
