closeBtn.setOnClickListener { stopSelf() }

val trigger1 = overlayView.findViewById<Button>(R.id.trigger1)
trigger1.setOnClickListener {
    // Координаты можно подобрать под конкретную игру
    RootShell.simulateTap(100, 1800)
}
