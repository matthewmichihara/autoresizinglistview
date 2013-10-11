package com.fourpool.autoresizinglistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 *
 */
public class AutoResizingListView extends ListView {
    public AutoResizingListView(Context context) {
        super(context);
    }

    public AutoResizingListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoResizingListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override public void setAdapter(final ListAdapter adapter) {
        super.setAdapter(adapter);

        adapter.registerDataSetObserver(new DataSetObserver() {
            @Override public void onChanged() {
                setHeight();
            }
        });

        setHeight();
    }

    private void setHeight() {
        ListAdapter adapter = getAdapter();
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, this);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = this.getLayoutParams();
        int dividerHeights = getDividerHeight() * (adapter.getCount() == 0 ? 0 : adapter.getCount() - 1);
        params.height = totalHeight + dividerHeights;
        setLayoutParams(params);
    }
}
