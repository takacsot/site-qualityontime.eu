---
title: "Why reactive programming is so important?"
kind: article
created_at: 2014-05-28 00:00
tags:
  - en
  - programming
  - it
---

How long it takes to do something for a computer? [Answer](http://norvig.com/21-days.html#answers)

- execute typical instruction 1/1,000,000,000 sec = 1 nanosec
- fetch from L1 cache memory  0.5 nanosec
- branch misprediction  5 nanosec
- fetch from L2 cache memory  7 nanosec
- Mutex lock/unlock 25 nanosec
- fetch from main memory  100 nanosec
- send 2K bytes over 1Gbps network  20,000 nanosec
- read 1MB sequentially from memory 250,000 nanosec
- fetch from new disk location (seek) 8,000,000 nanosec
- read 1MB sequentially from disk 20,000,000 nanosec
- send packet US to Europe and back 150 milliseconds = 150,000,000 nanosec 

Let's translate them to some human kind of human time [source](http://blog.codinghorror.com/the-infinite-space-between-words/):

1 CPU cycle | 0.3 ns  |  1 s
Level 1 cache access  |  0.9 ns   | 3 s
Level 2 cache access  |  2.8 ns   | 9 s
Level 3 cache access  |  12.9 ns  | 43 s
Main memory access  |  120 ns   | 6 min
Solid-state disk I/O  |  50-150 μs  | 2-6 days
Rotational disk I/O  | 1-10 ms  | 1-12 months
Internet: SF to NYC  | 40 ms  | 4 years
Internet: SF to UK   | 81 ms  | 8 years
Internet: SF to Australia  | 183 ms  |  19 years
OS virtualization reboot  |  4 s  | 423 years
SCSI command time-out  | 30 s  |  3000 years
Hardware virtualization reboot  |  40 s   | 4000 years
Physical system reboot  |  5 m |  32 millenia

So as soon as you are doing any IO you CPU can do lots of other stuff around.

No further reasoning....
