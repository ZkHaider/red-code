package com.zkhaider.red_code.materialdialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.AttrRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Convenience class for migrating old dialogs code. Not all methods are implemented yet.
 *
 * @deprecated Using MaterialDialog.Builder directly is recommended.
 */
public class MaterialDialogCompat {

    public static class Builder {

        private final MaterialDialog.Builder builder;

        private DialogInterface.OnClickListener negativeDialogListener;
        private DialogInterface.OnClickListener positiveDialogListener;
        private DialogInterface.OnClickListener neutralDialogListener;

        private DialogInterface.OnClickListener onClickListener;

        /**
         * Constructor using a context for this builder and the {@link MaterialDialog} it creates.
         */
        public Builder(@NonNull Context context) {
            builder = new MaterialDialog.Builder(context);
        }

        /**
         * Set the message to display using the given resource id.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setMessage(@StringRes int messageId) {
            builder.content(messageId);
            return this;
        }

        /**
         * Set the message to display.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setMessage(@NonNull CharSequence message) {
            builder.content(message);
            return this;
        }

        /**
         * Set the title using the given resource id.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setTitle(@StringRes int titleId) {
            builder.title(titleId);
            return this;
        }

        /**
         * Set the title displayed in the {@link MaterialDialog}.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setTitle(@NonNull CharSequence title) {
            builder.title(title);
            return this;
        }

        /**
         * Set the resource id of the {@link android.graphics.drawable.Drawable} to be used in the title.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setIcon(@DrawableRes int iconId) {
            builder.icon(iconId);
            return this;
        }

        /**
         * Set the {@link android.graphics.drawable.Drawable} to be used in the title.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setIcon(Drawable icon) {
            builder.icon(icon);
            return this;
        }

        /**
         * Set the attribute ID of the {@link android.graphics.drawable.Drawable} to be used in the title (e.g. android.R.attr.dialogicon)
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setIconAttribute(@AttrRes int attrId) {
            builder.iconAttr(attrId);
            return this;
        }

        /**
         * Set a listener to be invoked when the negative button of the dialog is pressed.
         *
         * @param textId   The resource id of the text to display in the negative button
         * @param listener The {@link android.content.DialogInterface.OnClickListener} to use.
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setNegativeButton(@StringRes int textId,
                                         DialogInterface.OnClickListener listener) {
            builder.negativeText(textId);
            negativeDialogListener = listener;
            return this;
        }

        /**
         * Set a listener to be invoked when the negative button of the dialog is pressed.
         *
         * @param text     The text to display in the negative button
         * @param listener The {@link android.content.DialogInterface.OnClickListener} to use.
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setNegativeButton(CharSequence text,
                                         DialogInterface.OnClickListener listener) {
            builder.negativeText(text);
            negativeDialogListener = listener;
            return this;
        }

        /**
         * Set a listener to be invoked when the positive button of the dialog is pressed.
         *
         * @param textId   The resource id of the text to display in the positive button
         * @param listener The {@link android.content.DialogInterface.OnClickListener} to use.
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setPositiveButton(@StringRes int textId,
                                         DialogInterface.OnClickListener listener) {
            builder.positiveText(textId);
            positiveDialogListener = listener;
            return this;
        }

        /**
         * Set a listener to be invoked when the positive button of the dialog is pressed.
         *
         * @param text     The text to display in the positive button
         * @param listener The {@link android.content.DialogInterface.OnClickListener} to use.
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setPositiveButton(CharSequence text,
                                         DialogInterface.OnClickListener listener) {
            builder.positiveText(text);
            positiveDialogListener = listener;
            return this;
        }

        /**
         * Set a listener to be invoked when the neutral button of the dialog is pressed.
         *
         * @param textId   The resource id of the text to display in the neutral button
         * @param listener The {@link android.content.DialogInterface.OnClickListener} to use.
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setNeutralButton(@StringRes int textId,
                                        DialogInterface.OnClickListener listener) {
            builder.neutralText(textId);
            neutralDialogListener = listener;
            return this;
        }

        /**
         * Set a listener to be invoked when the neutral button of the dialog is pressed.
         *
         * @param text     The text to display in the neutral button
         * @param listener The {@link android.content.DialogInterface.OnClickListener} to use.
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setNeutralButton(CharSequence text,
                                        DialogInterface.OnClickListener listener) {
            builder.neutralText(text);
            neutralDialogListener = listener;
            return this;
        }

        /**
         * Sets whether the dialog is cancelable or not.  Default is true.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setCancelable(boolean cancelable) {
            builder.cancelable(cancelable);
            return this;
        }

        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of the
         * selected item via the supplied listener. This should be an array type i.e. R.array.foo
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setItems(int itemsId, final DialogInterface.OnClickListener listener) {
            builder.items(itemsId);
            onClickListener = listener;
            return this;
        }

        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of the
         * selected item via the supplied listener.
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setItems(CharSequence[] items, DialogInterface.OnClickListener listener) {
            builder.items(items);
            onClickListener = listener;
            return this;
        }

        /**
         * Sets a custom {@link android.widget.ListAdapter} for the dialog's list
         *
         * @return This Builder object to allow for chaining of calls to set methods
         */
        public Builder setAdapter(ListAdapter adapter) {
            builder.adapter = adapter;
            return this;
        }

        /**
         * Creates a {@link android.app.AlertDialog} with the arguments supplied to this builder. It does not
         * {@link android.app.AlertDialog#show()} the dialog. This allows the user to do any extra processing
         * before displaying the dialog. Use {@link #show()} if you don't have any other processing
         * to do and want this to be created and displayed.
         */
        public AlertDialog create() {
            addButtonsCallback();
            addItemsCallBack();
            return builder.build();
        }

        /**
         * Creates a {@link android.app.AlertDialog} with the arguments supplied to this builder and
         * {@link android.app.AlertDialog#show()}'s the dialog.
         */
        public AlertDialog show() {
            AlertDialog dialog = create();
            dialog.show();
            return dialog;
        }

        private void addItemsCallBack() {
            if (onClickListener != null) {
                builder.itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                        onClickListener.onClick(dialog, which);
                    }
                });
            }
        }

        private void addButtonsCallback() {
            if (positiveDialogListener != null || negativeDialogListener != null) {
                builder.callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onNeutral(MaterialDialog dialog) {
                        if (neutralDialogListener != null) {
                            neutralDialogListener.onClick(dialog, DialogInterface.BUTTON_NEUTRAL);
                        }
                    }

                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        if (positiveDialogListener != null) {
                            positiveDialogListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                        }
                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {
                        if (negativeDialogListener != null) {
                            negativeDialogListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                        }
                    }
                });
            }
        }

        /**
         * Set a custom view resource to be the contents of the Dialog.
         *
         * @param view The view to use as the contents of the Dialog.
         * @return This
         */
        public Builder setView(View view) {
            boolean wrapInScrollView = !(view instanceof ScrollView || view instanceof AdapterView || view instanceof WebView);
            builder.customView(view, wrapInScrollView);
            return this;
        }

        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of the selected item via the supplied listener.
         *
         * @param itemsId      A resource ID for the items (e.g. R.array.my_items)
         * @param checkedItems specifies which items are checked. It should be null in which case no items are checked. If non null it must be exactly the same length as the array of items.
         * @param listener     notified when an item on the list is clicked. The dialog will not be dismissed when an item is clicked. It will only be dismissed if clicked on a button, if no buttons are supplied it's up to the user to dismiss the dialog.		 * @return
         * @return This
         */
        public Builder setMultiChoiceItems(@ArrayRes int itemsId, @Nullable final boolean[] checkedItems, final DialogInterface.OnMultiChoiceClickListener listener) {
            builder.items(itemsId);
            setUpMultiChoiceCallback(checkedItems, listener);
            return this;
        }

        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of the selected item via the supplied listener.
         *
         * @param items        the text of the items to be displayed in the list.
         * @param checkedItems specifies which items are checked. It should be null in which case no items are checked. If non null it must be exactly the same length as the array of items.
         * @param listener     notified when an item on the list is clicked. The dialog will not be dismissed when an item is clicked. It will only be dismissed if clicked on a button, if no buttons are supplied it's up to the user to dismiss the dialog.		 * @return
         * @return This
         */
        public Builder setMultiChoiceItems(String[] items, @Nullable final boolean[] checkedItems, final DialogInterface.OnMultiChoiceClickListener listener) {
            builder.items(items);
            setUpMultiChoiceCallback(checkedItems, listener);
            return this;
        }

        private void setUpMultiChoiceCallback(@Nullable final boolean[] checkedItems, final DialogInterface.OnMultiChoiceClickListener listener) {
            Integer selectedIndicesArr[] = null;
            /* Convert old style array of booleans-per-index to new list of indices */
            if (checkedItems != null) {
                ArrayList<Integer> selectedIndices = new ArrayList<>();
                for (int i = 0; i < checkedItems.length; i++) {
                    if (checkedItems[i]) {
                        selectedIndices.add(i);
                    }
                }
                selectedIndicesArr = selectedIndices.toArray(new Integer[selectedIndices.size()]);
            }

            builder.itemsCallbackMultiChoice(selectedIndicesArr, new MaterialDialog.ListCallbackMulti() {
                @Override
                public void onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
					/* which is a list of selected indices */
                    List<Integer> whichList = Arrays.asList(which);
                    if (checkedItems != null) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            /* save old state */
                            boolean oldChecked = checkedItems[i];
                            /* Record new state */
                            checkedItems[i] = whichList.contains(i);
                            /* Fire the listener if it changed */
                            if (oldChecked != checkedItems[i]) {
                                listener.onClick(dialog, i, checkedItems[i]);
                            }
                        }
                    }
                }
            });
        }

        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of the selected item via the supplied listener.
         *
         * @param items       the items to be displayed.
         * @param checkedItem specifies which item is checked. If -1 no items are checked.
         * @param listener    notified when an item on the list is clicked. The dialog will not be dismissed when an item is clicked. It will only be dismissed if clicked on a button, if no buttons are supplied it's up to the user to dismiss the dialog.
         * @return This
         */
        public Builder setSingleChoiceItems(String[] items, int checkedItem, final DialogInterface.OnClickListener listener) {
            builder.items(items);
            builder.itemsCallbackSingleChoice(checkedItem, new MaterialDialog.ListCallback() {
                @Override
                public void onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                    listener.onClick(dialog, which);
                }
            });
            return this;
        }

        /**
         * Set a list of items to be displayed in the dialog as the content, you will be notified of the selected item via the supplied listener.
         *
         * @param itemsId     the resource id of an array i.e. R.array.foo
         * @param checkedItem specifies which item is checked. If -1 no items are checked.
         * @param listener    notified when an item on the list is clicked. The dialog will not be dismissed when an item is clicked. It will only be dismissed if clicked on a button, if no buttons are supplied it's up to the user to dismiss the dialog.
         * @return This
         */
        public Builder setSingleChoiceItems(@ArrayRes int itemsId, int checkedItem, final DialogInterface.OnClickListener listener) {
            builder.items(itemsId);
            builder.itemsCallbackSingleChoice(checkedItem, new MaterialDialog.ListCallback() {
                @Override
                public void onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                    listener.onClick(dialog, which);
                }
            });
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener listener) {
            builder.cancelListener(listener);
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener listener) {
            builder.dismissListener(listener);
            return this;
        }

        public Builder setOnShowListener(DialogInterface.OnShowListener listener) {
            builder.showListener(listener);
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener listener) {
            builder.keyListener(listener);
            return this;
        }
    }
}