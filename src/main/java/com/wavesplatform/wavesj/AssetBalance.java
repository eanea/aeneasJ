package com.wavesplatform.wavesj;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wavesplatform.wavesj.transactions.IssueTransaction;
import com.wavesplatform.wavesj.transactions.IssueTransactionV2;

import java.io.Serializable;

public class AssetBalance implements Serializable {
    private final String assetId;
    private final Long balance;
    private final Boolean reissuable;
    private final Long minSponsoredAssetFee;
    private final Long sponsorBalance;
    private final Long quantity;
    private final IssueTransactionV2 issueTransactionV2;

    @JsonCreator
    public AssetBalance(@JsonProperty("assetId") String assetId, @JsonProperty("balance") Long balance,
                    @JsonProperty("reissuable") Boolean reissuable, @JsonProperty("minSponsoredAssetFee") Long minSponsoredAssetFee,
                    @JsonProperty("sponsorBalance") Long sponsorBalance, @JsonProperty("quantity") Long quantity,
                    @JsonProperty("issueTransaction") IssueTransactionV2 issueTransactionV2) {
        this.assetId = assetId;
        this.reissuable = reissuable;
        this.quantity = quantity;
        this.minSponsoredAssetFee = minSponsoredAssetFee;
        this.balance = balance;
        this.sponsorBalance = sponsorBalance;
        this.issueTransactionV2 = issueTransactionV2;
    }


    public AssetBalance(final String assetId, final Long balance, final Boolean reissuable, final Long minSponsoredAssetFee,
                        final Long sponsorBalance, final Long quantity, final IssueTransactionV2 issueTransactionV2, Object unused) {
        this.assetId = assetId;
        this.balance = balance;
        this.reissuable = reissuable;
        this.minSponsoredAssetFee = minSponsoredAssetFee;
        this.sponsorBalance = sponsorBalance;
        this.quantity = quantity;
        this.issueTransactionV2 = issueTransactionV2;
    }

    public String getAssetId() {
        return assetId;
    }

    public Long getBalance() {
        return balance;
    }

    public Boolean getReissuable() {
        return reissuable;
    }

    public Long getMinSponsoredAssetFee() {
        return minSponsoredAssetFee;
    }

    public Long getSponsorBalance() {
        return sponsorBalance;
    }

    public Long getQuantity() {
        return quantity;
    }

    public IssueTransaction getIssueTransactionV2() {
        return issueTransactionV2;
    }

    @Override
    public String toString() {
        return "AssetBalance{" +
                "assetId='" + assetId + '\'' +
                ", balance=" + balance +
                ", reissuable=" + reissuable +
                ", minSponsoredAssetFee=" + minSponsoredAssetFee +
                ", sponsorBalance=" + sponsorBalance +
                ", quantity=" + quantity +
                ", issueTransactionV2=" + issueTransactionV2 +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AssetBalance))
            return false;

        final AssetBalance that = (AssetBalance) o;

        if (getAssetId() != null ? !getAssetId().equals(that.getAssetId()) : that.getAssetId() != null)
            return false;
        if (getBalance() != null ? !getBalance().equals(that.getBalance()) : that.getBalance() != null)
            return false;
        if (getReissuable() != null ? !getReissuable().equals(that.getReissuable()) : that.getReissuable() != null)
            return false;
        if (getMinSponsoredAssetFee() != null ? !getMinSponsoredAssetFee().equals(that.getMinSponsoredAssetFee()) : that.getMinSponsoredAssetFee() != null)
            return false;
        if (getSponsorBalance() != null ? !getSponsorBalance().equals(that.getSponsorBalance()) : that.getSponsorBalance() != null)
            return false;
        if (getQuantity() != null ? !getQuantity().equals(that.getQuantity()) : that.getQuantity() != null)
            return false;
        return getIssueTransactionV2() != null ? getIssueTransactionV2().equals(that.getIssueTransactionV2()) : that.getIssueTransactionV2() == null;
    }

    @Override
    public int hashCode() {
        int result = getAssetId() != null ? getAssetId().hashCode() : 0;
        result = 31 * result + (getBalance() != null ? getBalance().hashCode() : 0);
        result = 31 * result + (getReissuable() != null ? getReissuable().hashCode() : 0);
        result = 31 * result + (getMinSponsoredAssetFee() != null ? getMinSponsoredAssetFee().hashCode() : 0);
        result = 31 * result + (getSponsorBalance() != null ? getSponsorBalance().hashCode() : 0);
        result = 31 * result + (getQuantity() != null ? getQuantity().hashCode() : 0);
        result = 31 * result + (getIssueTransactionV2() != null ? getIssueTransactionV2().hashCode() : 0);
        return result;
    }
}
