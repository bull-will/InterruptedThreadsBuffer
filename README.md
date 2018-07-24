# InterruptedThreadsBuffer
A number of producer and consumer threads put and get contents of a single-slot buffer. 
They are set to wait for the slot to be ready for them by neabs of a waiting line via node queue and then they are interrupted.
