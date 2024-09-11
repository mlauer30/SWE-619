## TA Feedback

Where is implementation of partial contract?

check for principal < 0, rate < 0 not found;



P.S. test code in unnecessary

principalDouble * (1 payment) >= principal

---

## Office Hours

Include this check to satisfy the requires clause

```
if(principal < 0 || rate < 0 || payment < 0) {
	throw new IllegalArgumentException("Principal, rate and payment must be positive");
}
```

