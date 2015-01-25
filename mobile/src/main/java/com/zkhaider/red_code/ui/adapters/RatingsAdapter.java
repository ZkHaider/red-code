package com.zkhaider.red_code.ui.adapters;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.zkhaider.red_code.R;

import java.util.List;

/**
 * Created by Haider on 1/24/2015.
 */
public class RatingsAdapter extends RecyclerView.Adapter<RatingsAdapter.RatingsViewHolder> {

    private Resources res;
    private Context mContext;
    private int score;

    GestureDetector gestureDetector;

    public RatingsAdapter() {
    }

    @Override
    public RatingsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.ratings_card, viewGroup, false);

        mContext = viewGroup.getContext();
        res = viewGroup.getContext().getResources();

        return new RatingsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RatingsViewHolder sessionViewHolder, int i) {

        // Set the circleIcon color to its score indicator
        if (score >= 80) {
//
//            mContext = mIcon.getContext();
//
//            mIcon.setBackground(res.getDrawable(R.drawable.circle_bad));
//
//            // Set Transformation
//            Transformation transformation = new RoundedTransformationBuilder()
//                    .borderColor(res.getColor(R.color.red_700))
//                    .borderWidthDp(10)
//                    .cornerRadiusDp(50)
//                    .oval(false)
//                    .build();
//
//            Picasso.with(mContext)
//                    .load(R.drawable.ic_bad_score)
//                    .fit()
//                    .transform(transformation)
//                    .into(mIcon);
        }

        if (score < 80 && score >= 20) {
//            mContext = mIcon.getContext();
//
//            // Set ImageView background color
//            mIcon.setBackground(res.getDrawable(R.drawable.circle_average));
//
//            // Set Transformation
//            Transformation transformation = new RoundedTransformationBuilder()
//                    .borderColor(res.getColor(R.color.yellow_700))
//                    .borderWidthDp(10)
//                    .cornerRadiusDp(50)
//                    .oval(false)
//                    .build();
//
//            Picasso.with(mContext)
//                    .load(R.drawable.ic_average_score)
//                    .fit()
//                    .transform(transformation)
//                    .into(mIcon);
        }
        if (score < 20) {
//            mContext = mIcon.getContext();
//
//            // Set ImageView background color
//            mIcon.setBackground(res.getDrawable(R.drawable.circle_good));
//
//            // Set Transformation
//            Transformation transformation = new RoundedTransformationBuilder()
//                    .borderColor(res.getColor(R.color.light_green_700))
//                    .borderWidthDp(10)
//                    .cornerRadiusDp(50)
//                    .oval(false)
//                    .build();
//
//            Picasso.with(mContext)
//                    .load(R.drawable.ic_good_score)
//                    .fit()
//                    .transform(transformation)
//                    .into(mIcon);
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class RatingsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected ImageView ratingsStars;
        protected TextView vSubtitle;
        protected TextView vDescription;

        // Variables for View
        private int originalHeight = 0;
        private boolean mIsViewExpanded = false;

        public RatingsViewHolder(View v) {
            super(v);

            v.setOnClickListener(this);

            ratingsStars = (ImageView) v.findViewById(R.id.ratingsStarIcon);
            vSubtitle = (TextView) v.findViewById(R.id.subtitle);
            vDescription = (TextView) v.findViewById(R.id.description);

            if (mIsViewExpanded == false) {
                vDescription.setEnabled(false);
                vDescription.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onClick(final View view) {
            if (originalHeight == 0) {
                originalHeight = view.getHeight();
            }

            ValueAnimator valueAnimator;
            if (!mIsViewExpanded) {
                vDescription.setVisibility(View.VISIBLE);
                vDescription.setEnabled(true);
                mIsViewExpanded = true;
                valueAnimator = ValueAnimator.ofInt(originalHeight, originalHeight + (int) (originalHeight * 2)+10);
            } else {
                mIsViewExpanded = false;
                valueAnimator = ValueAnimator.ofInt(originalHeight + (int) (originalHeight * 2)+10, originalHeight);

                Animation a = new AlphaAnimation(1.00f, 0.00f);

                a.setDuration(200);
                a.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        vDescription.setVisibility(View.INVISIBLE);
                        vDescription.setEnabled(false);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                // Set the animation on the barChart
                vDescription.startAnimation(a);
            }
            valueAnimator.setDuration(200);
            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    Integer value = (Integer) animation.getAnimatedValue();

                    view.getLayoutParams().height = value.intValue();
                    view.requestLayout();
                }
            });


            valueAnimator.start();

        }


    }

}