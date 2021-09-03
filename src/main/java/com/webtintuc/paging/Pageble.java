package com.webtintuc.paging;

import com.webtintuc.sort.Sorter;

public interface Pageble {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter  getSorter();
}
