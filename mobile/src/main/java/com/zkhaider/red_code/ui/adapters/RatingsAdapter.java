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
import com.zkhaider.red_code.models.Review;

import java.util.List;

/**
 * Created by Haider on 1/24/2015.
 */
public class RatingsAdapter extends RecyclerView.Adapter<RatingsAdapter.RatingsViewHolder> {

    private Resources res;
    private Context mContext;
    private List<Review> mReviews;


    GestureDetector gestureDetector;

    public RatingsAdapter(List<Review> reviews) {
        mReviews = reviews;
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
    public void onBindViewHolder(RatingsViewHolder ratingsViewHolder, int i) {

        ratingsViewHolder.vSubtitle.setText(mReviews.get(i).getSummary());

        double score = Double.parseDouble(mReviews.get(i).getAttributeRating().get(0).getValue());

        if (score == 0) {
            ratingsViewHolder.star1Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star2Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star3Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star4Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star5Ind.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score < 0) {
            ratingsViewHolder.star1Ind.setImageResource(R.drawable.ic_toggle_star_half);
            ratingsViewHolder.star2Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star3Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star4Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star5Ind.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score == 1) {
            ratingsViewHolder.star1Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star2Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star3Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star4Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star5Ind.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score < 2 && score > 1) {
            ratingsViewHolder.star1Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star2Ind.setImageResource(R.drawable.ic_toggle_star_half);
            ratingsViewHolder.star3Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star4Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star5Ind.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score == 2) {
            ratingsViewHolder.star1Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star2Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star3Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star4Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star5Ind.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score > 2 && score < 3) {
            ratingsViewHolder.star1Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star2Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star3Ind.setImageResource(R.drawable.ic_toggle_star_half);
            ratingsViewHolder.star4Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star5Ind.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score == 3) {
            ratingsViewHolder.star1Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star2Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star3Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star4Ind.setImageResource(R.drawable.ic_toggle_star_outline);
            ratingsViewHolder.star5Ind.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score > 3 && score < 4) {
            ratingsViewHolder.star1Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star2Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star3Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star4Ind.setImageResource(R.drawable.ic_toggle_star_half);
            ratingsViewHolder.star5Ind.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score == 4) {
            ratingsViewHolder.star1Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star2Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star3Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star4Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star5Ind.setImageResource(R.drawable.ic_toggle_star_outline);
        } else if (score > 4 && score < 5) {
            ratingsViewHolder.star1Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star2Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star3Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star4Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star5Ind.setImageResource(R.drawable.ic_toggle_star_half);
        } else if (score == 5) {
            ratingsViewHolder.star1Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star2Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star3Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star4Ind.setImageResource(R.drawable.ic_toggle_star);
            ratingsViewHolder.star5Ind.setImageResource(R.drawable.ic_toggle_star);
        }

    }


    @Override
    public int getItemCount() {
        return mReviews.size();
    }

    public static class RatingsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected ImageView ratingsStars;
        protected TextView vSubtitle;
        protected TextView vDescription;

        // Star icons
        public ImageView star1Ind;
        public ImageView star2Ind;
        public ImageView star3Ind;
        public ImageView star4Ind;
        public ImageView star5Ind;


        // Variables for View
        private int originalHeight = 0;
        private boolean mIsViewExpanded = false;

        public RatingsViewHolder(View v) {
            super(v);

            v.setOnClickListener(this);

            ratingsStars = (ImageView) v.findViewById(R.id.ratingsStarIcon);
            vSubtitle = (TextView) v.findViewById(R.id.subtitle);
            vDescription = (TextView) v.findViewById(R.id.description);

            star1Ind = (ImageView) v.findViewById(R.id.star1Ind);
            star2Ind = (ImageView) v.findViewById(R.id.star2Ind);
            star3Ind = (ImageView) v.findViewById(R.id.star3Ind);
            star4Ind = (ImageView) v.findViewById(R.id.star4Ind);
            star5Ind = (ImageView) v.findViewById(R.id.star5Ind);

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