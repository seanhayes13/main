#pragma once

#include <iostream>

#define AWAKE "I'm up! I'm up! Turn off the alarm"
#define SLEEPING "*snoring loudly*"

using namespace std;

void usingIfDef() {
	for (int i = 0; i < 2; i++) {
		if (i % 2 == 0) {
#ifdef AWAKE
#undef AWAKE
			cout << SLEEPING << endl;
#endif
		}
		else {
#ifndef AWAKE
#define AWAKE "I'm up! I'm up! Turn off the alarm"
			cout << AWAKE << endl;
#endif
		}
	}
}